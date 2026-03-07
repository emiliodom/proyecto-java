package com.educacion.recursos.controlador;

import com.educacion.recursos.modelo.Recurso;
import com.educacion.recursos.repositorio.RecursoRepositorio;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/recursos")
public class RecursoControlador {
    private final RecursoRepositorio repo;

    public RecursoControlador(RecursoRepositorio repo) {
        this.repo = repo;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("resources", repo.findAll());
        return "recursos/recursos-lista";
    }

    @GetMapping("/impresion")
    public String impresion(Model model) {
        model.addAttribute("resources", repo.findAll());
        return "recursos/recursos-impresion";
    }

    @GetMapping("/creditos")
    public String creditos(Model model) {
        model.addAttribute("creditos", "Desarrollado por el equipo de educación");
        return "recursos/recursos-creditos";
    }

    @GetMapping("/new")
    public String form(Model model) {
        model.addAttribute("resource", new Recurso());
        return "recursos/recursos-formulario";
    }

    @PostMapping
    public String create(@ModelAttribute Recurso resource) {
        if (resource.getDisponible() == null) {
            resource.setDisponible(false);
        }
        repo.save(resource);
        return "redirect:/recursos";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        Recurso resource = repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID inválido: " + id));
        model.addAttribute("resource", resource);
        return "recursos/recursos-formulario";
    }

    @PostMapping("/{id}")
    public String update(@PathVariable Long id, @ModelAttribute Recurso resource) {
        resource.setId(id);
        if (resource.getDisponible() == null) {
            resource.setDisponible(false);
        }
        repo.save(resource);
        return "redirect:/recursos";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        repo.deleteById(id);
        return "redirect:/recursos";
    }
}
