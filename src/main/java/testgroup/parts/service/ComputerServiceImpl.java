package testgroup.parts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import testgroup.parts.dao.ComputerDAO;
import testgroup.parts.dao.ComputerDAOImpl;
import testgroup.parts.model.Computer;


import java.util.List;

@Service
public class ComputerServiceImpl implements ComputerService {
    private ComputerDAO computerDAO;

    @Autowired
    public void setComputerDAO(ComputerDAO computerDAO) {
        this.computerDAO = computerDAO;
    }

    @Override
    @Transactional
    public List<Computer> allComputers(int page) {
        return computerDAO.allComputers(page);
    }
    @Override
    @Transactional
    public List<Computer> allallComputers() {
        return computerDAO.allallComputers();
    }

    @Override
    @Transactional
    public List<Computer> findComputers(String name) {
        return computerDAO.findComputers(name);
    }

    @Override
    @Transactional
    public List<Computer> trueComputers(int page) {
        return computerDAO.trueComputers(page);
    }

    @Override
    @Transactional
    public List<Computer> falseComputers(int page) {
        return computerDAO.falseComputers(page);
    }

    @Override
    @Transactional
    public void add(Computer computer) {
        computerDAO.add(computer);
    }

    @Override
    @Transactional
    public void delete(Computer computer) {
        computerDAO.delete(computer);
    }

    @Override
    @Transactional
    public void edit(Computer computer) {
        computerDAO.edit(computer);
    }

    @Override
    @Transactional
    public Computer getById(int id) {
        return computerDAO.getById(id);
    }

    @Override
    @Transactional
    public Computer getByName(String name) {
        return computerDAO.getByName(name);
    }

    @Override
    @Transactional
    public int computersCount() {
        return computerDAO.computersCount();
    }

    @Override
    @Transactional
    public int partsCount() {
        return computerDAO.partsCount();
    }
    @Override
    @Transactional
    public int partsCount1() {
        return computerDAO.partsCount1();
    }
    @Override
    @Transactional
    public int partsCount2() {
        return computerDAO.partsCount2();
    }

    @Override
    @Transactional
    public boolean checkName(String name) {
        return computerDAO.checkName(name);
    }
}
