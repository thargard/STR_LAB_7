package com.example.borism.command.grouppersons;

import com.example.borism.command.Command;
import com.example.borism.command.CommandResult;
import com.example.borism.exception.IncorrectDataException;
import com.example.borism.exception.ServiceException;
import com.example.borism.model.Person;
import com.example.borism.service.PersonService;
import com.example.borism.util.pages.Page;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.List;

import static com.example.borism.command.grouppersons.constant.GroupConstant.LISTGROUP;

public class WelcomeCommand implements Command {
    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException, IncorrectDataException {
        PersonService personService = new PersonService();
        List<Person> clients = personService.findAll();
        if (!clients.isEmpty()) {
            request.setAttribute(LISTGROUP, clients);
        }
        return new CommandResult(Page.WELCOME_PAGE.getPage(), false);
    }
}
