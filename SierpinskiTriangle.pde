public void setup()
{
	size(800,800);
	background(0);
	//smooth();
	sierpinski(0,height/2+(800*Math.sqrt(3)/2/2),800);
}
public void draw()
{
	
}
public void mouseDragged()//optional
{

}
public void sierpinski(double x, double y, double len) 
{
	if(len>10)
	{
		sierpinski(x,y,len/2);
		sierpinski(x+len/2,y,len/2);
		sierpinski(x+len/4,y-(len/2*Math.sqrt(3)/2),len/2);
	}
	else
	{
		fill((float)Math.random()*256,(float)Math.random()*256,(float)Math.random()*256);
		triangle((float)(x), (float)(y), (float)(x+len), (float)(y), (float)(x+len/2), (float)(y-(len*Math.sqrt(3)/2)));
	}
}