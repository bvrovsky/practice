public class FirmList2Demo{//взаимодействие фирм и проектов
    public static void main (String[]args){
        FirmList2 sp1=new FirmList2("Рассвет-2010");
        FirmList2 sp2=new FirmList2("Рассвет-2020");
        //в массив args при запуске метода main(String[]args) ввели 10 фирм: по 5 для каждого проекта
        int j=0;//индекс массива args
        //добавление фирм в первый проект
        for (int i=0; i<5; i++){
            int id=Integer.valueOf(args[j]); j++;//получен int-эквивалент из String
            String name=args[j]; j++;
            int numOfEmploy=Integer.valueOf(args[j]); j++;
            double baseSalary=Double.valueOf(args[j]); j++;//получен double-эквивалент из String
            //добавить фирму
            sp1.addFirm(new Firm(id, name, numOfEmploy, baseSalary));
        }
        //добавление фирм во второй проект
        for (int i=0; i<5; i++){
            int id=Integer.valueOf(args[j]); j++;
            String name=args[j]; j++;
            int numOfEmploy=Integer.valueOf(args[j]); j++;
            double baseSalary=Double.valueOf(args[j]); j++;
            //добавить фирму
            sp2.addFirm(new Firm(id, name, numOfEmploy, baseSalary));
        }
        System.out.println("Сформированы следующие проекты:");
        System.out.printf("%s,\n%s\n\n", sp1, sp2);
        //пытаемся вставить в sp1 фирму с тем же ключом
        if (!sp1.addFirm(new Firm(12345, "Восход",7, 65000.00))){
            System.out.printf("В проект %s добавить фирму 12345 не удалось:\n", sp1.getName());
            System.out.println("нарушена уникальность ключа.");
        }
        //выборка данных
        sp1.putFirmList();
        sp1.aboveAvgBaseSalary().putFirmList();
        sp1.betweenBaseSalary(60000.00f,90000.00f).putFirmList();
        //удаление студента по id
        sp1.delFirm(51515);
        //выборка данных
        System.out.println("После удаления фирмы:");
        sp1.putFirmList();
        System.out.println();
        //то же для второй группы
        //выборка данных
        sp2.putFirmList();
        sp2.aboveAvgBaseSalary().putFirmList();
        sp2.betweenBaseSalary(60000.00f,90000.00f).putFirmList();
        //удаление фирмы по id
        sp2.delFirm(31313);
        //выборка данных
        System.out.println("После удаления фирмы:");
        sp2.putFirmList();
        System.out.println();
        //Проверяем, есть ли в группах фирмы с заданным ключом
         System.out.println("Проверка наличия фирм c заданным ключом:");
        int n=21212;
        Firm f1=sp1.getFirm(n);
        System.out.printf("В списке %s:\n", sp1.getName());
        if (f1==null) System.out.printf("Нет фирмы с ключом %d\n", n);
        else System.out.println(f1);
        n=43554;
        f1=sp1.getFirm(n);
        if (f1==null) System.out.printf("Нет фирмы с ключом %d\n", n);
        else System.out.println(f1);
        n=10101;
        f1=sp2.getFirm(n);
        System.out.printf("В списке %s:\n", sp2.getName());
        if (f1==null) System.out.printf("Нет фирмы с ключом %d\n",n);
        else System.out.println(f1);
        //сортировка
        System.out.println("\nСортровка массива ссылок");
      System.out.println("Массив до сортировки");
      sp1.putFirmList();
      sp1.sortByBaseSalary().putFirmList();
    }//main
}//FirmList2Demo
        
        
        
       