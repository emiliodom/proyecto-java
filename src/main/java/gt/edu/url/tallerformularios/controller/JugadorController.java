package gt.edu.url.tallerformularios.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import gt.edu.url.tallerformularios.model.Jugador;
import gt.edu.url.tallerformularios.service.JugadorService;

@Controller
public class JugadorController {

    private final JugadorService jugadorService;

    public JugadorController(JugadorService jugadorService) {
        this.jugadorService = jugadorService;
    }

    // 1. Muestra el formulario vacío
    @GetMapping("/jugadores/nuevo")
    public String mostrarFormulario(Model model) {
        model.addAttribute("jugador", new Jugador());
        return "formulario";
    }

    // 2. Recibe el formulario, guarda y redirige
    @PostMapping("/jugadores")
    public String registrarJugador(@ModelAttribute Jugador jugador) {
        jugadorService.guardar(jugador);
        return "redirect:/jugadores";
    }

    // 3. Muestra la lista
    @GetMapping("/jugadores")
    public String listarJugadores(Model model) {
        model.addAttribute("jugadores", jugadorService.listarTodos());
        model.addAttribute("total", jugadorService.contar());
        return "lista";
    }

    // 4. Muestra el detalle de uno solo (ruta parametrizada)
    @GetMapping("/jugadores/{numero}")
    public String verJugador(@PathVariable int numero, Model model) {
        Jugador jugador = jugadorService.buscarPorNumero(numero);
        if (jugador == null) {
            return "redirect:/jugadores";
        }
        model.addAttribute("jugador", jugador);
        model.addAttribute("numero", numero);
        return "detalle";
    }
}