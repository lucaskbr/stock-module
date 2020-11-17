package stock.modules.local.services;

import stock.modules.local.Local;
import stock.modules.local.LocalRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class UpdateLocalById {

    @Inject
    LocalRepository localRepository;

    public Local execute(Long id, Local local) {
        return localRepository.update(id, local);
    }

}