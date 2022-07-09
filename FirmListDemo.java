public class FirmListDemo{//взаимодействие фирм и пректов
    public static void SetProjectStatus(FirmList project, String status){
        //назначить проекту статус
        project.setListName(project.getListName()+" " + status);
    }
    public static void main(String[]args){
        //создаем проекты с фирмами
        FirmList pr1=new FirmList1("Проект <Рассвет-2010> ", 5);
        FirmList pr2=new FirmList2("Проект по программированию");
        //далее работаем с интерфейсными ссылками pr1 и pr2
        //в массив args при запуске метода main (String[]args)
        //ввели 10 фирм: по 5 для каждого проекта
        int j=0;//индекс массива args
        //добавление фирм в первый проект
        for (int i=0; i<5; i++){
            int id=Integer.valueOf(args[j]); j++;
            String name=args[j]; j++;
            int numOfEmploy=Integer.valueOf(args[j]); j++;
            double baseSalary=Double.valueOf(args[j]); j++;
            //добавить фирму
            pr1.addFirm(new Firm(id, name, numOfEmploy, baseSalary));
        }
        //добавление фирм во второй проект
        for (int i=0; i<5; i++){
        int id=Integer.valueOf(args[j]); j++;
            String name=args[j]; j++;
            int numOfEmploy=Integer.valueOf(args[j]); j++;
            double baseSalary=Double.valueOf(args[j]); j++;
            //добавить фирму
            pr2.addFirm(new Firm(id, name, numOfEmploy, baseSalary));
        }
        System.out.println("Сформированы следущие проекты:");
        System.out.printf("%s,\n%s\n\n", pr1, pr2);
        //пытаемся вставить лишнюю фирму в первый проект
        if (!pr1.addFirm(new Firm (54321, "Закат", 6, 61000.50))){
            System.out.printf(
            "В проект %s добавить фирму 12345 не удалось:\n",
            pr2.getListName());
            System.out.println("превышен лимит");
        }
        //пытаемся вставить фирму с тем же ключом во второй проект
       if (!pr2.addFirm(new Firm (12345, "Восход",7, 65000.00))){
            System.out.printf("В проект %s добавить фирму 12345 не удалось:\n", pr1.getListName());
            System.out.println("нарушена уникальность ключа");
        }
        System.out.println();
        //выборка данных
        //выводим списки фирм для проекта pr1
        pr1.putFirmList();
        pr1.aboveAvgBaseSalary().putFirmList();
        pr1.betweenBaseSalary(60000.00f,90000.00f).putFirmList();
        //удаление фирмы по id
        pr1.delFirm(51515);
        //выводим список фирм pr1 после удаления фирмы
        System.out.println("После удаления фирмы:");
        pr1.putFirmList();
        System.out.println();
        //то же для второй группы
        //выводим списки фирм для проекта pr2
        pr2.putFirmList();
        pr2.aboveAvgBaseSalary().putFirmList();
        pr2.betweenBaseSalary(60000.00f,90000.00f).putFirmList();
        //удаление фирмы по id
        pr2.delFirm(31313);
        //выводим список фирм pr1 после удаления фирмы
        System.out.println("После удаления фирмы:");
        pr2.putFirmList();
        System.out.println();
        //Проверяем, есть ли в проектах фирмы с заданным ключом
        System.out.println("Проверка наличия фирм c заданным ключом:");
        int n=21212;
        Firm f1=pr1.getFirm(n);
        System.out.printf("В списке %s:\n", pr1.getListName());
        if (f1==null) System.out.printf("Нет фирмы с ключом %d\n", n);
        else System.out.println(f1);
        n=41414;
        f1=pr1.getFirm(n);
        if (f1==null) System.out.printf("Нет фирмы с ключом %d\n", n);
        else System.out.println(f1);
        n=10101;
        f1=pr2.getFirm(n);
        System.out.printf("В списке %s:\n", pr2.getListName());
        if (f1==null) System.out.printf("Нет фирмы с ключом %d\n",n);
        else System.out.println(f1);
        System.out.println();
        //назначаем проектам статус
        //для групп, реализуемых разными классами, используем один и тот же
        //метод setProjectStatus(), использующий в качестве параметра интерфейсную ссылку
        SetProjectStatus(pr1, "ВЫПОЛНЯЕТСЯ");
        SetProjectStatus(pr2, "ЗАКОНЧЕН");
        System.out.println("После назначения проектам статуса имеем:");
        System.out.println(pr1.getListName()+";");
        System.out.println(pr2.getListName()+".");
        pr1.sortByBaseSalary().putFirmList();
        pr2.sortByBaseSalary().putFirmList();
    }//main
}//FirmListDemo