package testgroup.parts.service;

import testgroup.parts.model.Computer;

import java.util.List;

public interface ComputerService {
    List< Computer> allComputers(int page);
    List< Computer> trueComputers(int page);
    List< Computer> falseComputers(int page);
    List <Computer> findComputers(String name);
    void add(Computer computer);
    void delete(Computer computer);
    void edit(Computer computer);
    Computer getByName(String name);
    List<Computer> allallComputers();
    Computer getById(int id);
    int computersCount();
    int partsCount();
    int partsCount1();
    int partsCount2();
    boolean checkName(String name);
}
