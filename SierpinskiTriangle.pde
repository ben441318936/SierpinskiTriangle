public void setup()
{
	size(800,800);
	background(0);
	
}
public void draw()
{

	sierpinski(width/2,height/2,800,800);
}
public void mouseDragged()//optional
{

}
public void sierpinski(double a, double b, double len, double minLen) 
{
	double x=a-(len/2);
	double y=b+(len*Math.sqrt(3)/6);
	if(len>minLen)
	{
		sierpinski(x,y,len/2,minLen);
		sierpinski(x+len/2,y,len/2,minLen);
		sierpinski(x+len/4,y-(len/2*Math.sqrt(3)/2),len/2,minLen);
	}
	else
	{
		fill((float)Math.random()*256,(float)Math.random()*256,(float)Math.random()*256);
		triangle((float)(x), (float)(y), (float)(x+len), (float)(y), (float)(x+len/2), (float)(y-(len*Math.sqrt(3)/2)));
	}
}