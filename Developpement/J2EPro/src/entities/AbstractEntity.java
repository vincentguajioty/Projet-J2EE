package entities;

public abstract class AbstractEntity
{
	@Override
	public abstract String toString();
	
	public String getClassStr()
	{
		return "AbstractEntity";
	}
}
