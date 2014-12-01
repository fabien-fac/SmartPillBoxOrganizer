package fiducial;
/*
 TUIO Java GUI Demo
 Copyright (c) 2005-2014 Martin Kaltenbrunner <martin@tuio.org>
 
 Permission is hereby granted, free of charge, to any person obtaining
 a copy of this software and associated documentation files
 (the "Software"), to deal in the Software without restriction,
 including without limitation the rights to use, copy, modify, merge,
 publish, distribute, sublicense, and/or sell copies of the Software,
 and to permit persons to whom the Software is furnished to do so,
 subject to the following conditions:
 
 The above copyright notice and this permission notice shall be
 included in all copies or substantial portions of the Software.
 
 THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
 IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR
 ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF
 CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

import java.awt.Graphics;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;
import java.util.TimerTask;

import javax.swing.JComponent;

import Classes.GestionDetection;
import TUIO.TuioBlob;
import TUIO.TuioCursor;
import TUIO.TuioListener;
import TUIO.TuioObject;
import TUIO.TuioTime;

public class TuioDemoComponent extends JComponent implements TuioListener {
	private Hashtable<Long, TuioDemoObject> objectList = new Hashtable<Long, TuioDemoObject>();
	private Set<String> listDisparus = new HashSet<String>();

	public static final int object_size = 60;
	public static final int table_size = 760;
	public boolean verbose = true;
	public GestionDetection gestion = new GestionDetection();
	public TimerTask timerTask = null;
	
	public void test(){
		System.out.println("test");
		timerTask = new TimerTask() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("Envoi info");
				gestion.setListCasesDisparues(listDisparus);
			}
		};
		java.util.Timer timer = new java.util.Timer();
		timer.scheduleAtFixedRate(timerTask, 0, 1000);
	}
	
	public void addTuioObject(TuioObject tobj) {
		TuioDemoObject demo = new TuioDemoObject(tobj);
		objectList.put(tobj.getSessionID(), demo);
		if (timerTask == null){
			test();
		}
		String StringID = String.valueOf(tobj.getSessionID());
		if (tobj.getSessionID() < 29){
			if (listDisparus.contains(StringID)) {
				listDisparus.remove(StringID);
			}
		}
	}

	public void updateTuioObject(TuioObject tobj) {

	}

	public void removeTuioObject(TuioObject tobj) {
		objectList.remove(tobj.getSessionID());
		String StringID = String.valueOf(tobj.getSessionID());
		if (tobj.getSessionID() < 29){
			listDisparus.add(StringID);
		}
	}
	
	public void update(Graphics g) {

	}

	@Override
	public void addTuioBlob(TuioBlob arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addTuioCursor(TuioCursor arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeTuioBlob(TuioBlob arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeTuioCursor(TuioCursor arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateTuioBlob(TuioBlob arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateTuioCursor(TuioCursor arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void refresh(TuioTime arg0) {
		// TODO Auto-generated method stub
	}
}
