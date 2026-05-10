package com.example.baozirest.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.baozirest.model.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}