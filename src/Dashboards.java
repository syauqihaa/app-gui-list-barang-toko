// Model Dashboard
public class Dashboards { 
    
    private int id;
    private String nama;
    private int harga;
    private int persediaan;

    public Dashboards(int id, String nama, int harga, int persediaan)
    {
        this.id = id;
        this.nama = nama;
        this.harga = harga;
        this.persediaan = persediaan;
    }

    public int getId()
    {
        return id;
    }

    public String getNama()
    {
        return nama;
    }

    public int getHarga()
    {
        return harga;
    }

    public int getPersediaan()
    {
        return persediaan;
    }
}
