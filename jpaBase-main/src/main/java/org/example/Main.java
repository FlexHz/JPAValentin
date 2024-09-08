package org.example;

import Entidades.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory EMF = Persistence.createEntityManagerFactory("PersistenciaValentin");
        EntityManager EM = EMF.createEntityManager();
        System.out.println("en marcha locura!");

        try {
            EM.getTransaction().begin();

            //Creamos algunas entidades
            Factura fac1 = new Factura();
            Cliente cli1 = new Cliente("Fornes", "Valentin", 45447949);
            Cliente cli2 = new Cliente("Porcel", "Gaspar", 45447948);
            Domicilio dom1 = new Domicilio("Corrientes Sur", 211);
            Domicilio dom2 = new Domicilio("Corrientes Norte", 112);
            Articulo art1 = new Articulo(255, "Repuesto", 7500);
            Articulo art2 = new Articulo(120, "Service", 20000);
            Categoria cat1 = new Categoria("Repuesto");
            Categoria cat2 = new Categoria("Service");
            DetalleFactura det1 = new DetalleFactura();
            DetalleFactura det2 = new DetalleFactura();

            //Relacioamos las entidades
            cli1.setDomicilio(dom1);
            dom1.setCliente(cli1);
            cli2.setDomicilio(dom2);
            dom2.setCliente(cli2);
            art1.getArtCategoria().add(cat1);
            art2.getArtCategoria().add(cat2);
            cat1.getCatArticulo().add(art1);
            cat2.getCatArticulo().add(art2);
            det1.setArticulo(art1);
            det1.setCantidad(6);
            det1.setSubtotal(45000);
            det1.setFactura(fac1);
            det2.setFactura(fac1);
            det2.setArticulo(art2);
            det2.setCantidad(5);
            det2.setSubtotal(100000);
            art1.getArtDetalleFactura().add(det1);
            art1.getArtDetalleFactura().add(det2);
            fac1.setCliente(cli1);
            fac1.setFecha("01/09/24");
            fac1.setNumero(1);
            fac1.setTotal(145000);
            fac1.getFactDetalleFactura().add(det1);
            fac1.getFactDetalleFactura().add(det2);

            EM.persist(fac1);
            EM.flush();
            EM.getTransaction().commit();

        } catch (Exception e) {

            EM.getTransaction().rollback();
            System.out.println(e.getMessage());
            System.out.println("Error al grabar la clase");
        }

        // Cerrar el EntityManager y el EntityManagerFactory
        EM.close();
        EMF.close();
    }
}
