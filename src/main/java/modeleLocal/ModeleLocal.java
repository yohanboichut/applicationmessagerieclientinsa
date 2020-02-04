package modeleLocal;

import facade.FacadeApplicationMessagerie;
import facade.MessageLight;
import facade.UtilisateurLight;
import facade.exceptions.*;
import rmistuff.MonService;

import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Collection;

public class ModeleLocal implements FacadeApplicationMessagerie {


    MonService monService;


    public ModeleLocal() {
        try {
            Registry registry = LocateRegistry.getRegistry(10000);
            monService = (MonService) registry.lookup(MonService.serviceName);
        } catch (AccessException e) {
            e.printStackTrace();
        }
        catch (NotBoundException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void inscription(String s, String s1) throws LoginDejaPrisException, InformationsNonConformesException {
        try {
            monService.inscription(s,s1);
        } catch (RemoteException e) {
            throw new RuntimeException("Connexion probleme");
        }
    }

    @Override
    public void resiliser(String s, String s1) throws DonneesIncoherentesException, InformationsNonConformesException {
        try {
            monService.resiliser(s, s1);
        } catch (RemoteException e) {
            throw new RuntimeException("Connexion probleme");
        }
    }

    @Override
    public long connexion(String s, String s1) throws LoginDejaPrisException, InformationsNonConformesException, UtilisateurDejaConnecteException {
        try {
            return monService.connexion(s, s1);
        } catch (RemoteException e) {
            throw new RuntimeException("Connexion probleme");
        }
    }

    @Override
    public void deconnexion(long l) throws InformationsNonConformesException {
        try {
            monService.deconnexion(l);
        } catch (RemoteException e) {
            throw new RuntimeException("Connexion probleme");
        }
    }

    @Override
    public long envoyerUnMessage(long l, long l1, String s) throws UtilisateurNonConnecteException, UtilisateurInexistantException {
        try {
            return monService.envoyerUnMessage(l, l1, s);
        } catch (RemoteException e) {
            throw new RuntimeException("Connexion probleme");
        }
    }

    @Override
    public Collection<MessageLight> getMesMessages(long l) throws UtilisateurNonConnecteException {
        try {
            return monService.getMesMessages(l);
        } catch (RemoteException e) {
            throw new RuntimeException("Connexion probleme");
        }
    }

    @Override
    public Collection<UtilisateurLight> getListeDesInscrits(long l) throws UtilisateurNonConnecteException, UtilisateurInexistantException {
        try {
            return monService.getListeDesInscrits(l);
        } catch (RemoteException e) {
            throw new RuntimeException("Connexion probleme");
        }
    }

    @Override
    public MessageLight getMessageById(long l, long l1) throws UtilisateurNonConnecteException, MessageInexistantException, UtilisateurInexistantException {
        try {
            return monService.getMessageById(l,l1);
        } catch (RemoteException e) {
            throw new RuntimeException("Connexion probleme");
        }
    }
}
