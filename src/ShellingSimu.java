public class ShellingSimu extends AutomateCellSimu {
    private  Shelling prb;
    public ShellingSimu()
    {
        super();
        prb = new Shelling(40,40,2,5);
        prb.initGrid();
        prb.test();

    }


    public void execute()
    {
        this.prb.segragation();
        gui.reset();
        ++this.date;
        tracer(prb.couleur,prb.grille,prb.n,prb.m,1);

    }


    public void restart()
    {
        gui.reset();
        prb.reInitSh();
        this.date =0;
        tracer(prb.couleur,prb.grille,prb.n,prb.m,1);
    }
}
