package fr.mariech.facturier.controller;

import fr.mariech.facturier.controller.dto.ClientDto;
import fr.mariech.facturier.entity.Client;
import fr.mariech.facturier.service.ClientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping({"/", "/clients"})
public class ClientController {

    final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping()
    public String getClients(Model model) {
        List<Client> clients = clientService.getAllClients();
        model.addAttribute("clients", clients);
        return "index";
    }

    @GetMapping(path = "/{clientId}")
    public String getClients(@PathVariable long clientId, Model model) {
        List<Client> clients = clientService.getAllClients();
        model.addAttribute("clients", clients);
        Optional<ClientDto> client = clientService.getClientById(clientId);

        if (client.isPresent()) {
            model.addAttribute("clientRequested", client.get());
            return "index";
        }

        return "404";
    }


}
