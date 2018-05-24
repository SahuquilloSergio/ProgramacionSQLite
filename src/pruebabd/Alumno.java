package pruebabd;

public class Alumno {

    private String Nome, Rua;
    private int Id, Edade;

    public Alumno() {
    }

    public Alumno(String Nome, String Rua, int Id, int Edade) {
        this.Nome = Nome;
        this.Rua = Rua;
        this.Id = Id;
        this.Edade = Edade;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getRua() {
        return Rua;
    }

    public void setRua(String Rua) {
        this.Rua = Rua;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getEdade() {
        return Edade;
    }

    public void setEdade(int Edade) {
        this.Edade = Edade;
    }

    @Override
    public String toString() {
        return "Alumno\n" + "Nome= " + Nome + ", Rua= " + Rua + ", Id= " + Id + ", Edade= " + Edade;
    }
    
    
}
