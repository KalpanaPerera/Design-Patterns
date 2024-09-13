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

}