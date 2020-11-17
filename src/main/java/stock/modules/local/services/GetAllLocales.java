package stock.modules.local.services;

import stock.modules.local.Local;
import stock.modules.local.LocalRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class GetAllLocales {

    @Inject
    LocalRepository localRepository;

    public List<Local> execute() {
        return localRepository.list();
    }

}