public class Firm {//сущность - фирма
    private final static String FIRM_FORMAT_STRING="Фирма: %d, %s, %d, %1.2f";
    //поля - переменные экземпляра (скрыты в классе)
    private int id;//номер фирмы - ключевое
    private String name;//название
    private int numOfEmploy;//количество сотрудников
    private double baseSalary;//базовая зарплата 
    //методы 
    //конструктор без параметров
    public Firm(){
        id=0; name=""; numOfEmploy=0; baseSalary=0.0;
    }
    //конструктор с параметрами 
    //инициализирует поля значениями параметров
    public Firm(int id, String name, int numOfEmploy, double baseSalary){
        this.id=id; this.name=name; this.numOfEmploy=numOfEmploy; this.baseSalary=baseSalary;
    }
    //конструктор с параметрами
    //строит клон объекта, переданного как параметр
    public Firm(Firm fm){
        id=fm.id; name=fm.name; numOfEmploy=fm.numOfEmploy; baseSalary=fm.baseSalary;
    }
    //public-интерфейс доступа к полям:
    //геттеры
    public int getId(){return id;}
    public String getName(){return name;}
    public int getNumOfEmploy(){return numOfEmploy;}
    public double getBaseSalary(){return baseSalary;}
    //сеттеры
    public void setId(int id){this.id=id;}
    public void setName(String name){this.name=name;}
    public void setNumOfEmploy(int numOfEmploy){this.numOfEmploy=numOfEmploy;}
    public void setBaseSalary(double baseSalary){this.baseSalary=baseSalary;}
    //возвращает строку описания объекта
    //(экземпляры класса Firm)
    public String toString(){
        return String.format(FIRM_FORMAT_STRING, id, name, numOfEmploy, baseSalary);
    }
}//Firm
    
    
  