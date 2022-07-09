//интерфес задаёт методы (процедуры и функции)
//списка фирм, абстрагируясь от их реализации
public interface FirmList{
    //1)установить имя списка
    void setListName(String name);
    //2)получить имя списка фирм
    String getListName();
    //3)получить кол-во фирм в списке
    int getFirmNum();
    //4)получить из списка фирму с заданным ключом
    Firm getFirm(int id);
    //5)добавить фирму firm в список 
    boolean addFirm(Firm firm);
    //6)удалить из списка фирму с заданным ключом
    boolean delFirm(int id);
    //7)вернуть среднюю базовую зарплату для списка
    double avgBaseSalary();
    //8)вернуть спислк фирм, у которых базовая зарплата ниже среднего 
    FirmList aboveAvgBaseSalary();
    //9)вернуть список фирм, у которых базовая зарплата в диапозоне [b1, b2]
    FirmList betweenBaseSalary(double bs1, double bs2);
    //10)вывести список фирм в окно терминала
    void putFirmList();
    //10)отсортировать список фирм в окно терминала
    FirmList sortByBaseSalary();
}