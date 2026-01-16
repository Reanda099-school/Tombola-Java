public class Numero
{
    private Integer num;
    private Boolean uscito;

    public Numero(Integer n)
    {
        num = n;
        uscito = false;
    }

    public Integer getNum()
    {
        return num;
    }

    public Boolean getUscito()
    {
        return uscito;
    }
    public void segnaNumero()
    {
        uscito = true;
    }

    
}
