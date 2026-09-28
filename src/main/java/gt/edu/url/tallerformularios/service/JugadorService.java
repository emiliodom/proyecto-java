package gt.edu.url.tallerformularios.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import gt.edu.url.tallerformularios.model.Jugador;

@Service
public class JugadorService {

    // La "memoria" de la aplicación: se vacía cada vez que reinicias.
    private final List<Jugador> jugadores = new ArrayList<>();

    public void guardar(Jugador jugador) {
        jugadores.add(jugador);
    }

    public List<Jugador> listarTodos() {
        return jugadores;
    }

    public int contar() {
        return jugadores.size();
    }

    public Jugador buscarPorNumero(int numero) {
        if (numero < 1 || numero > jugadores.size()) {
            return null;
        }
        return jugadores.get(numero - 1);
    }
}