package stock.modules.provider.services;

import stock.modules.provider.Provider;
import stock.modules.provider.ProviderRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class GetProviderById {

    @Inject
    ProviderRepository providerRepository;

    public Provider execute(Long id) {
       return providerRepository.getById(id);
    }

}