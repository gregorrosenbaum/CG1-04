package tests;

import vectorlib.Point3;
import vectorlib.Vector3;
import Cameras.PerspectiveCamera;

public class CamUnit {

	public static void main(String[] args) {
		PerspectiveCamera testCam = new PerspectiveCamera(new Point3(0, 0, 0), new Vector3(0, 0,-1), new Vector3(0,1,0), Math.PI / 4);
		return;
	}

}
