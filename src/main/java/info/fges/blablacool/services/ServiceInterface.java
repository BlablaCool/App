package info.fges.blablacool.services;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Valentin on 15/03/15.
 */
public abstract class ServiceInterface<T, Id extends Serializable>
{
    public abstract T findById(Id id);

    public abstract List<T> findAll();

    public abstract void create(T t);

    public abstract void delete(T t);

    public abstract void deleteById(Id id);
}