package com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository;

import java.util.List;

import com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.modelo.Transferencia;

public interface ITransferenciaRepository {
    public void insertar(Transferencia transferencia);
    public List<Transferencia> leerTransferencias();
}
