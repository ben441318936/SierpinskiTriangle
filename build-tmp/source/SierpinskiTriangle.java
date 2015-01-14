import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class SierpinskiTriangle extends PApplet {

public double triMinLen, triLen;
public boolean zoomIn=false, zoomOut=false;
public boolean moreTriangles=false, lessTriangles=false;
public boolean rotLeft=false, rotRight=false;
public double radLeft=0, radRight=0;
public boolean rotLeftAcc=false, rotRightAcc=false;
public double radAccLeft=0, radAccRight=0;
public void setup()
{
	size(800,800);
	background(0);
	noStroke();
	line(0,400,800,400);
	line(400,0,400,800);
	triMinLen=(width+height)/2/8;
	triLen=(width+height)/2;
	frameRate(60);
}
public void draw()
{		
	background(0);
	if(rotRightAcc==true) {radAccRight++;}
	if(rotLeftAcc==true)  {radAccLeft--; }
	translate((float)width/2,(float)(height/2+(triLen*Math.sqrt(3)/3-triLen*Math.sqrt(3)/2/2)));
	if(rotRight==true) 
	{ 
		radRight+=(radAccRight/1000);
		rotate((float)radRight);
	}
	if(rotLeft==true)  
	{ 
		radLeft+=(radAccLeft/1000);
		rotate((float)radLeft);
	}
	translate((float)-width/2, (float)(-(height/2+(triLen*Math.sqrt(3)/3-triLen*Math.sqrt(3)/2/2))));
	fill(255,102,102);	//work on stages of color shifting in relation to rotation
	sierpinski(width/2,height/2+(triLen*Math.sqrt(3)/3-triLen*Math.sqrt(3)/2/2),triLen,triMinLen);
	if(moreTriangles==true) { triMinLen/=1.115f; }
	if(lessTriangles==true) { triMinLen*=1.115f; }
	if(triMinLen<(width+height)/2/100) {triMinLen=(width+height)/2/100;}
	if(triMinLen>(width+height)/2) {triMinLen=(width+height)/2;}
	if(zoomIn==true)  { triLen+=5; }
	if(zoomOut==true) { triLen-=5; }
	if(triLen<triMinLen) { triLen=triMinLen; }
}	
public void mouseDragged()//optional
{

}
public void keyPressed()
{
	if(key=='w' || key=='W') { moreTriangles=true; }
	if(key=='s' || key=='S') { lessTriangles=true; }
	if(key==CODED)
	{
		if(keyCode==UP)   { zoomIn=true;  }
		if(keyCode==DOWN) { zoomOut=true; }
		if(keyCode==LEFT) { rotLeft=true;  rotLeftAcc=true; }
		if(keyCode==RIGHT){ rotRight=true; rotRightAcc=true;}
	}
	if(key=='r' || key=='R') 
	{
		rotLeft=false;
		rotRight=false;
	}
	if(key==' ') 
	{
		rotLeftAcc=false;
		rotRightAcc=false;
		radAccLeft=0;
		radAccRight=0;
	}
}
public void keyReleased()
{
	if(key=='w' || key=='W') { moreTriangles=false; }
	if(key=='s' || key=='S') { lessTriangles=false; }
	if(key==CODED)
	{
		if(keyCode==UP)   { zoomIn=false;  }
		if(keyCode==DOWN) { zoomOut=false; }
		if(keyCode==LEFT) { rotLeftAcc=false; }
		if(keyCode==RIGHT){ rotRightAcc=false;}
	}
}
public void sierpinski(double a, double b, double len, double minLen) 
{
	if(len>minLen)
	{
		a=a-len/4; b=b+len*Math.sqrt(3)/6-len/2*Math.sqrt(3)/6;
		sierpinski(a,b,len/2,minLen);
		a=a+len/2;
		sierpinski(a,b,len/2,minLen);
		a=a-len/4; b=b+len/2*Math.sqrt(3)/6-len*Math.sqrt(3)/3;
		sierpinski(a,b,len/2,minLen);
	}
	else
	{
		double x=a-(len/2);
		double y=b+(len*Math.sqrt(3)/6);
		triangle((float)(x), (float)(y), (float)(x+len), (float)(y), (float)(x+len/2), (float)(y-(len*Math.sqrt(3)/2)));
	}
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "SierpinskiTriangle" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
