package stock.modules.local.services;


import stock.modules.local.Local;
import stock.modules.local.LocalRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class CreateLocal {

    @Inject
    LocalRepository localRepository;


    public Local execute(Local local) {
        return localRepository.save(local);
    }

}