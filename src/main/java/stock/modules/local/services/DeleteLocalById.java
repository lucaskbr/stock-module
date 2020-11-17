package stock.modules.local.services;


import stock.modules.local.LocalRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class DeleteLocalById {

    @Inject
    LocalRepository localRepository;

    public void execute(Long id) {
        localRepository.remove(id);
    }

}