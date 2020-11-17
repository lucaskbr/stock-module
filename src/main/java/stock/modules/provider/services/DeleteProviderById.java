package stock.modules.provider.services;


import stock.modules.provider.ProviderRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class DeleteProviderById {

    @Inject
    ProviderRepository providerRepository;

    public void execute(Long id) {
        providerRepository.remove(id);
    }

}