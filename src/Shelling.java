import java.util.HashSet;
import java.awt.Point;
import java.util.Random;
public class Shelling extends AutomatesCellulaires{

    private HashSet<Point> cellulesVacantes;
    private  int seuil;
    public Shelling(int n,int m,int K,int nbrcol)
    {
        super(n,m,nbrcol+1);
        this.idAutomate = 1;
        cellulesVacantes = new HashSet<Point>();
        this.seuil = K;
    }


    public void test()
    {
        reInit = 1;
       //initCouleur(nbrEtats);
        for(int i=0;i<n;++i)
        {
            for(int j=0;j<m;++j)
            {
                if(j%3!=0){
                    Random r = new Random();
                    // Cellule cell = new Cellule(r.nextInt(10)%(nbrEtats-1)-1,10);
                    // grille[i][j] = cell;
                    initVal(i, j, r.nextInt(10)%(nbrEtats-1)-1);
                }
                else{
                    // Cellule cell = new Cellule(-1,10);
                    // grille[i][j] = cell;
                    initVal(i, j,-1);
                }
            }
        }
        celluleVac();
    }

    public void reInitSh()
    {
        if(reInit == 0)
        {
            reInit();
            cellulesVacantes.clear();
            celluleVac();
        }

    }

    private void celluleVac(){
        for(int i=0;i<n;++i)
        {
            for(int j=0;j<n;++j)
            {
                if (grille[i][j].getCurrentState() == -1)
                {
                    Point p = new Point(i,j);
                    cellulesVacantes.add(p);
                    //System.out.println(i+" ; "+j);
                }
            }
        }
    }
    private int stateCell(int i, int j,int mState)
    {
        //int mState = grille[i][j].currentState;
        int nbrVoisinsViavant=0;
        if(this.grille[i][cyclique(j+1,m)].getCurrentState() != mState &&this.grille[i][cyclique(j+1,m)].getCurrentState() !=-1)
        {
            ++nbrVoisinsViavant;
        }
        if(this.grille[i][cyclique(j+1,m)].getCurrentState() != mState && this.grille[i][cyclique(j+1,m)].getCurrentState() !=-1 ){++nbrVoisinsViavant;}
        if(this.grille[i][cyclique(j-1,m)].getCurrentState()!=mState && this.grille[i][cyclique(j-1,m)].getCurrentState()!=-1){++nbrVoisinsViavant;}
        if(this.grille[cyclique(i+1,n)][cyclique(j+1,m)].getCurrentState()!=mState && this.grille[cyclique(i+1,n)][cyclique(j+1,m)].getCurrentState()!=-1){++nbrVoisinsViavant;}
        if( this.grille[cyclique(i+1,n)][cyclique(j-1,m)].getCurrentState()!=mState && this.grille[cyclique(i+1,n)][cyclique(j-1,m)].getCurrentState()!=-1){++nbrVoisinsViavant;}
        if(this.grille[cyclique(i+1,n)][j].getCurrentState()!=mState && this.grille[cyclique(i+1,n)][j].getCurrentState()!=-1){++nbrVoisinsViavant;}
        if(this.grille[cyclique(i-1,n)][cyclique(j+1,m)].getCurrentState()!=mState && this.grille[cyclique(i-1,n)][cyclique(j+1,m)].getCurrentState()!=-1){++nbrVoisinsViavant;}
        if(this.grille[cyclique(i-1,n)][cyclique(j-1,m)].getCurrentState()!=mState && this.grille[cyclique(i-1,n)][cyclique(j-1,m)].getCurrentState()!=-1){++nbrVoisinsViavant;}
        if(this.grille[cyclique(i-1,n)][j].getCurrentState()!=mState && this.grille[cyclique(i-1,n)][j].getCurrentState()!=-1){++nbrVoisinsViavant;}
        return nbrVoisinsViavant;
    }
    public void demenage(int i,int j)
    {
        int mState = grille[i][j].getCurrentState();
        //int originalState = grille[i][j].originalState;
        int K = stateCell(i, j,mState);
        if(K>this.seuil && mState!=-1)
        {
            // J'aime pas mes voisins je vais regarder d'autre habitas
            //elle devient vacante,au lieu de creer un autre attribut on peut juste donner à state -1
            Point p = new Point(i,j);
            for(Point pt :cellulesVacantes)
            {
                if (stateCell(pt.x, pt.y,mState)<=this.seuil)
                {
                    //System.out.println("i :"+i+";;j :"+j+"::::"+pt.x+" ;;"+pt.y+";; "+stateCell(pt.x, pt.y,mState));
                    grille[pt.x][pt.y].setCurrentState( mState);
                    cellulesVacantes.remove(pt);
                    grille[i][j].setCurrentState(-1);
                    cellulesVacantes.add(p);
                    break;
                }
            }
        }
    }

    public void segragation()
    {
        reInit = 0;
        for(int i=0;i<n;++i)
        {
            for(int j=0;j<m;++j)
            {
                Point p =new Point(i,j);
                if( !cellulesVacantes.contains(p))
                {
                    demenage(i, j);
                }
            }
        }
    }

}
