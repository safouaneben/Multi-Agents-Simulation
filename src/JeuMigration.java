public class JeuMigration extends AutomatesCellulaires{

    public JeuMigration(int n,int m,int nbrEtats)
    {
        super(n,m,nbrEtats);
        this.idAutomate = 0;
    }

    public void test()
    {
        for(int i=0;i<n;++i)
        {
            for(int j=0;j<n;++j)
            {
                initVal(i, j, (j%(i+1))%5);
            }
        }
    }

    private int stateCell(int i, int j)
    {
        int mState = (grille[i][j].getCurrentState()+1)%nbrEtats;
        int nbrVoisinsViavant=0;
        if(this.grille[i][cyclique(j+1,m)].getCurrentState() == mState)
        {
            ++nbrVoisinsViavant;
        }
        if(this.grille[i][cyclique(j+1,m)].getCurrentState() == mState ){++nbrVoisinsViavant;}
        if(this.grille[i][cyclique(j-1,m)].getCurrentState() == mState){++nbrVoisinsViavant;}
        if(this.grille[cyclique(i+1,n)][cyclique(j+1,m)].getCurrentState()==mState){++nbrVoisinsViavant;}
        if( this.grille[cyclique(i+1,n)][cyclique(j-1,m)].getCurrentState()==mState){++nbrVoisinsViavant;}
        if(this.grille[cyclique(i+1,n)][j].getCurrentState()==mState){++nbrVoisinsViavant;}
        if(this.grille[cyclique(i-1,n)][cyclique(j+1,m)].getCurrentState()==mState){++nbrVoisinsViavant;}
        if(this.grille[cyclique(i-1,n)][cyclique(j-1,m)].getCurrentState()==mState){++nbrVoisinsViavant;}
        if(this.grille[cyclique(i-1,n)][j].getCurrentState()==mState){++nbrVoisinsViavant;}
        return nbrVoisinsViavant;
    }

    public void nextStep()
    {
        reInit = 0;
        for(int i=0;i<n;++i)
        {
            for(int j=0;j<m;++j)
            {
                int mstate = stateCell(i, j);
                int currentState = grille[i][j].getCurrentState();
                if (mstate>=3 )
                {
                    grille[i][j].setNextState((currentState+1)%nbrEtats);
                }
            }
        }
        updateGrille();

    }

    private void updateGrille()
    {
        for(int i=0;i<n;++i)
        {
            for(int j=0;j<m;++j)
            {
                grille[i][j].setCurrentState(grille[i][j].getNextState());
            }
        }
    }

}
