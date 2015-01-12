public void setup()
{
	size(500,500);

}
public void draw()
{

}
public void mouseDragged()//optional
{

}
public void sierpinski(double x, double y, double len) 
{
	if(len>20)
	{
		triangle(x, y, x-len/2, y-(sqrt(3)/2)*len, x+len/2, y+(sqrt(3)/2)*len);
	}
	
}