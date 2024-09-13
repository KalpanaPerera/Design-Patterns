abstract class TV 
{
    Remote remote;
    TV(Remote r) 
    {
        this.remote = r;
    }
    abstract void on();
    abstract void off();
}

class Sony extends TV
{
    Remote remoteType;
    Sony(Remote r) 
    {
        super(r);
        this.remoteType = r;
    }
  
    public void on()
    {
        System.out.print("Sony TV ON: ");
        remoteType.on();
    }
    
    public void off()
    {
        System.out.print("Sony TV OFF: ");
        remoteType.off();
    }
}
  
}