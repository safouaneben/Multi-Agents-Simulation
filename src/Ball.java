import java.awt.Point;
class Ball extends Point
{
    private int pas_x;//1 ou -1
    private int pas_y;//1 ou -1
    private int xInit;//position initiale en abscisse
    private int yInit;//position initiale en ordonnee
    private int vivant;//1 ou 0
    private int vivantApres;
    private int originalState;
    public Ball(int x, int y)
    {
        super(x,y);
        vivant = 0;
        vivantApres = 0;
        xInit = x;
        yInit = y;
        pas_x = 1;
        pas_y = 1;
    }

    public int getXInit()  //un get d'initialisation des x
    {
        return xInit;
    }
    public int getVivant(){
        return this.vivant;
    }
    public int getVivantApres(){
        return this.vivantApres;
    }
    public int getoriginalState(){
        return this.originalState;
    }
    public int getYInit()
    {
        return yInit;
    }

    public void rebondissement(int pas_x1,int pas_y1,int taille_x,int taille_y){
    // Gère le cas où les balles touchent un mur
        if (this.x+pas_x*pas_x1>taille_x)
        {
            if(this.y+pas_y*pas_y>taille_y)
            {
                this.translate(-pas_x*pas_x1+2*(taille_x-this.x),-pas_y*pas_y1+2*(taille_y-this.y) );
                pas_x = -pas_x;
                pas_y = -pas_y;

            }
            else if (this.y+pas_y*pas_y1<0)
            {
                this.translate(-pas_x*pas_x1+2*(taille_x-this.x),-pas_y*pas_y1-2*this.y );
                pas_x = -pas_x;
                pas_y = -pas_y;
            }
            else
            {
                this.translate(-pas_x*pas_x1+2*(taille_x-this.x),pas_y*pas_y1 );
                pas_x = -pas_x;
            }
        }
        else if (this.x+pas_x*pas_x1<0)
        {
            if(this.y+pas_y*pas_y1>taille_y)
            {
                this.translate(-pas_x*pas_x1-2*this.x,-pas_y*pas_y1+2*(taille_y-this.y) );
                pas_x = -pas_x;
                pas_y = -pas_y;
            }
            else if (this.y+pas_y*pas_y1<0)
            {
                this.translate(-pas_x*pas_x1-2*this.x,-pas_y*pas_y1-2*this.y );
                pas_x = -pas_x;
                pas_y = -pas_y;
            }
            else
            {
                this.translate(-pas_x*pas_x1-2*this.x,pas_y*pas_y1 );
                pas_x = -pas_x;

            }
        }
        else
        {
            if(this.y+pas_y*pas_y1>taille_y)
            {
                this.translate(pas_x*pas_x1,-pas_y*pas_y1+2*(taille_y-this.y) );
                pas_y = -pas_y;
            }
            else if (this.y+pas_y*pas_y1<0)
            {
                this.translate(pas_x*pas_x1,-pas_y*pas_y1-2*this.y );
                pas_y = -pas_y;
            }
            else
            {
                this.translate(pas_x*pas_x1,pas_y*pas_y1 );
            }
        }
    }

    public void rebondissement(int pas_x1,int pas_y1) // Valeurs par défauts
    {
        rebondissement(pas_x1, pas_y1,500,500);
    }
}
