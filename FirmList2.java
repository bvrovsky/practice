public class FirmList2{//Сущность - Проект с фирмами
//В данном классе список фирм реализован на основе динамического связного списка
//Класс описывает элемент динамического связного списка
//Каждый экземпляр данного класса является началом списка следущих за ним связных элементов списка
    
//статическая переменная  класса задаёт формат строки описания объекта
private final static String FIRM_FORMAT_STRING=
"Проект: %s, число фирм: %3d";
    //поля
    private Firm firm;//информ часть элемента списка
    private FirmList2 next;//указатель на след элемент
    //методы=конструкторы 
    //конструктор без параметров
    public FirmList2(){
        firm=null; next=null;
    }
    public FirmList2(String name){//передаётся название списка для инициализации головы списка фирм
        firm=new Firm();
        firm.setName(name); firm.setId(0); firm.setNumOfEmploy(0); firm.setBaseSalary(0.0);
        next=null;
    }
    public FirmList2(Firm fm){
        //инициализирует элемент списка для фирм fm
        firm=fm; next=null;
    }
    //методы определяющие поведение элемента списка фирм
    public void setName(String name){//назначить имя списку(проекту)
        firm.setName(name);
    }
    public String getName(){return firm.getName();}//вернуть имя списка
    public int getNum(){//вернуть число фирм в списке
        //головой списка ялвяется текущий объект, т.е. объект запустивший метод (this)
        int num=0;//число элементов
        FirmList2 el=next;//перешли к элементу, на который указывает голова списка
        while (el !=null){//пока в списке есть элементы
            num++;
            el=el.next;
        }
        return num;
    }
    public Firm getFirm(int id){
        //вернуть из списка фирму с заданным ключом
        //головой списка является текущий объект
        if (next==null) return null;//если список пуст
        FirmList2 el=next;//el - ссылка на очередной элемент списка
        while (el !=null){//пока в списке есть элементы
            if (el.firm.getId()==id) return el.firm;//фирма найдена
            //перейти к следующему элементу списка
            el=el.next;
        }
        return null;//фирма не найдена
    }
    //сформировать строку описания объекта 
    public String toString(){
        return String.format(FIRM_FORMAT_STRING, firm.getName(), getNum());
    }
    //добавить фирму в список фирм
    public boolean addFirm(Firm firm){
        //головой списка является текущий объект
        //фирму нельзя добавить, если его id уже упомянут в списке
        if (getFirm(firm.getId()) !=null) return false;
        FirmList2 el=new FirmList2(firm);//создали новый элемент списка
        if (next==null) next=el;//вставили в пустой список
        else {//вставить первым в непустой список
            FirmList2 old=next;
            next=el;
            el.next=old;
        }
        return true;
    }
    //удалить фирму из списка фирм
    public boolean delFirm(int id){
        //головой списка является текущий объект
        FirmList2 el=this;//el.next-очередной элемент списка
        while (el.next !=null){//пока в списке есть элементы
            if (el.next.firm.getId()==id){//фирма найдена
                el.next=el.next.next;//и удален
                return true;
            }
            //перейти к следующему элементу списка
            el=el.next;
        }
        return false;//фирма не найдена
    }
    //запрос
    //вернуть среднюю базовую зарплату для списка фирм
    public double avgBaseSalary(){
        //головой списка является текущий объект
        if (next==null) return 0;
        double avg=0; int num=0;
        FirmList2 el=next;//el-очередной элемент списка
        while (el !=null){//пока в списке есть элементы
            avg=avg+el.firm.getBaseSalary();
            num=num+1;
            //перейти к следующему элементу списка
            el=el.next;
        }
        return avg/num;
    }
    //запрос
    //вернуть список фирм, у которых базовая зарплата ниже среднего из списка
    //головой которого является текущий объект
    public FirmList2 aboveAvgBaseSalary(){
        //возвращает ссылку на объект определяемого класса-
        //рекурсия при определенных данных
        double avg=avgBaseSalary();
        //формируется новый список с головой head
        //фирмы не дублируются
        FirmList2 head=new FirmList2(String.format
        ("Фирмы, у которых базовая зарплата ниже среднего %.2f: ", avg));
        FirmList2 el=next;//el-очередной элемент основного списка
        while (el !=null){//пока в списке есть элементы
            if (el.firm.getBaseSalary()<avg)
            head.addFirm(el.firm);
            //перейти к следующему элементу списка
            el=el.next;
        }
        return head;
    }
    //запрос
    //вернуть список фирм с базовой зарплатой в диапозоне [ball1,ball2]
    //из списка, головой которого является текущий объект
    public FirmList2 betweenBaseSalary(double bs1, double bs2){
        //возвращает ссылку на объект определяемого класса-
        //рекурсия при определенных данных
        FirmList2 head=new FirmList2(String.format
        ("Фирмы, у которых базовая зарплата в диапозоне от %.2f до %.2f: ", bs1, bs2));
        FirmList2 el=next;//el-очередной элемент основого списка
        while (el !=null){//пока в списке есть элементы
            double bs=el.firm.getBaseSalary();
            if ((bs>=bs1)&&(bs<=bs2))
            head.addFirm(new Firm(el.firm));
            //перейти к следующему элементу списка
            el=el.next;
        }
        return head;
    }
    //выводит список фирм в окно терминала
    public void putFirmList(){
        //головой списка является текущий объект
        System.out.println(firm.getName());
        System.out.printf("%s%7s%16s%15s%17s\n",
        "Номер", "Ключ", "Название", "Сотрудников", "Базовая зарплата");
        FirmList2 el=next;//el-очередной элемент списка
        int i=1;//номер фирмы
        while (el !=null){//пока в списке есть элементы
            System.out.printf(" %-7d %-12d %-15s %-10d %-8.2f\n",
            i, el.firm.getId(), el.firm.getName(), el.firm.getNumOfEmploy(), el.firm.getBaseSalary());
            //перейти к следующему элементу списка
            el=el.next;
            i=i+1;
        }//while
    }//putFirmList()
    //сортировка
public void sortBaseSalary() {
//головой списка является текущий объект
boolean flag = true;
    while (!flag) {
        FirmList2 el=this;//el.next-очередной элемент списка
        FirmList2 old = el.next;
        flag = false;
        while (el.next !=null){//пока в списке есть элементы
            if (el.firm.getBaseSalary()>el.next.firm.getBaseSalary())
            old=el;
            el=el.next;
 
                flag = true;
        }
    el=el.next;
    }
}
public FirmList2 sortByBaseSalary(){
    FirmList2 el = next;
    FirmList2 temp = new FirmList2();
    FirmList2 list = new FirmList2("Отсортированный список");
    while (el != null){
        list.addFirm(new Firm(el.firm));
        el = el.next;
    }
    boolean flag = false;
    while (!flag){
        el = list.next;
        flag = true;
        while (el.next != null){
            if (el.firm.getBaseSalary() > el.next.firm.getBaseSalary()){
                temp.firm = el.firm;
                el.firm = el.next.firm;
                el.next.firm = temp.firm;
                el = el.next;
                flag = false;
                break;
            } else {el = el.next;}
        }
    }
    return list;
}                       
}//FirmList2
            
            
        
            
            
    