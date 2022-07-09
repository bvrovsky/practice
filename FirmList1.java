public class FirmList1 implements FirmList{//сущность - проект
    //статическая переменная класса задаёт минимально возможное число фирм
    //нужна для конструктора без параметров
    private final static int MIN_NUM=5;
    //статическая переменная класса задаёт формат строки описания объекта
    private final static String PROJECT_FORMAT_STRING="Проект: %s, число фирм: %d";
    //поля-переменные экземпляра(свойства проекта)
    private String name;//название проекта
    private Firm[] firmArr;//ссылка на список фирм
    private int num;//количество фирм
    //конструкторы 
    public FirmList1(){
        name="";
        num=0;//пока список не заполнен
        firmArr=new Firm[MIN_NUM];//выделение памяти 
    }
    public FirmList1(String name, int numMax){
        //задаётся название проекта и максимальное возможное число фирм в проекте
        this.name=name;
        num=0;//пока список не заполнен
        firmArr=new Firm[numMax];//выделение памяти
    }
    //метод-сеттер - меняет шифр проекта
    public void setListName(String name){this.name=name;}
    //методы-геттеры
    //возвращает шифр проекта
    public String getListName(){return name;}
    //возвращает число фирм в проекте
    public int getFirmNum(){return num;}
    //возвращает фирму с заданным значением ключевого поля из списка фирм
    public Firm getFirm(int id){
        for (int i=0; i<num; i++)
        if (firmArr[i].getId()==id) return firmArr[i];
        return null;
    }
    //сформировать строку описания объекта
    public String toString(){
        return String.format(PROJECT_FORMAT_STRING, name, num);
    }
    //добавить фирму в список группы
    public boolean addFirm(Firm fm){
        if (num==firmArr.length) return false;
        for (int i=0; i<num; i++)
        if (firmArr[i].getId()==fm.getId()) return false;
        firmArr[num]=fm;
        num++;
        return true;
    }
    //удалить фирму из списка проекта
    public boolean delFirm(int id){
     int i;
     for (i=0; i<num; i++)//ищем фирму в списке
     if (firmArr[i].getId()==id) break;
     if (i==num)//прошли весь список
     return false;//фирма с таким id нет
     //студент найден, i-его индекс
     //удаляем из списка
     for (i=i+1; i<num; i++)//i-ая ссылка будет заперта (i+1)-ой
     firmArr[i-1]=firmArr[i];//смещение ссылок
     firmArr[i-1]=null;
     //в массиве стало на 1 фирму меньше
     num--;
     return true;
    }
    //запрос
    //вернуть среднюю базовую зарплату для списка фирм
    public double avgBaseSalary(){
        if (num==0) return 0;
        double avg=0;
        for (int i=0; i<num; i++)
        avg=avg+firmArr[i].getBaseSalary();
        return avg/num;
    }
    //запрос
    //вернуть список фирм, у которых базовая зарплата ниже средней
    public FirmList aboveAvgBaseSalary(){//возвращает подсписок:
        //возвращает ссылку на элемент определяемого класса -
        //используется рекрсия при определении данных
        double avg=avgBaseSalary();
        //создаем подсписок
        FirmList1 list = new FirmList1(String.format
        ("Фирмы, у которых базовая зарплата ниже средней %.2f: ", avg), num);
        for (int i=0; i<num; i++)
        if (firmArr[i].getBaseSalary()<avg) list.addFirm(firmArr[i]);
        return list;
    }
    //запрос
    //вернуть список фирм с базовой зарплатой в интервале [baseSalary1,baseSalary2]
    public FirmList betweenBaseSalary(double bs1, double bs2){//возвращает подсписок
        //возвращает ссылку на элемент определяемого класса-
        //используется рекурсия при определении данных
        //создаем подсписок
        FirmList1 list = new FirmList1(String.format
        ("Фирмы, у которых базовая зарплата в интервале от %.2f до %.2f: ", bs1, bs2), num);
        for (int i=0; i<num; i++){
            double bs=firmArr[i].getBaseSalary();
            if ((bs>=bs1)&&(bs<=bs2))
                list.addFirm(firmArr[i]);
            }
            return list;
        }
    //выводится список студентов в окно терминала
    public void putFirmList(){
        System.out.println(name);
        if (num!=0){
            System.out.printf("%14s%16s%15s%17s\n",
            "Ключ", "Название", "Cотрудников","Базовая Зарплата");
            for (int i=0; i<num; i++)
            System.out.printf(" %-7d %-12d %-15s %-10d %-8.2f\n",
            i+1, firmArr[i].getId(), firmArr[i].getName(), firmArr[i].getNumOfEmploy(), firmArr[i].getBaseSalary());
        }//if
    }//putProject
    public FirmList sortByBaseSalary() {
        FirmList1 list = new FirmList1(String.format("Сортировка массива: "), num); 
    if (num == 0) return null;
    Firm[] arr = new Firm[num];
    Firm temp;
    for (int i = 0; i < num; i++)
        arr[i] = firmArr[i];
    
    boolean flag = false;
    while (!flag) {
        flag = true;
        for (int j = 0; j < arr.length - 1; j++)
            if (arr[j].getBaseSalary()>(arr[j+1].getBaseSalary())) {
                temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
                flag = false;
                break;
            }
    }
    for (int j = 0; j < arr.length - 1; j++)
            list.addFirm(arr[j]);
    return list;
  } 
}//Project