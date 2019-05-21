package testgroup.parts.dao;


import testgroup.parts.model.Computer;

import java.util.List;

public interface ComputerDAO {
        List<Computer> allComputers(int page);
        List<Computer> trueComputers(int page);
        List<Computer> falseComputers(int page);
        void add(Computer computer);
        void delete(Computer computer);
        void edit(Computer computer);
        Computer getById(int id);
        Computer getByName(String name);
        List <Computer> allallComputers();
        int computersCount();
        int partsCount();
        int partsCount1();
        int partsCount2();
        boolean checkName(String name);
        List <Computer> findComputers(String name);
        }