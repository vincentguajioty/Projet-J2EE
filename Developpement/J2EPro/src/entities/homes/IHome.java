package entities.homes;

import java.util.*;

import entities.AbstractEntity;
import entities.Plat;
import entities.PlatId;

public interface IHome<T>
{
    public void persist(T me);

    public void remove(T me);

    public T merge(T me);

    public T findById(int me);

    public HashSet<T> findAll();
}