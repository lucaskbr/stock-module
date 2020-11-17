package stock.modules.provider.services;

import stock.modules.provider.Provider;
import stock.modules.provider.ProviderRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class UpdateProviderById {

    @Inject
    ProviderRepository providerRepository;

    public Provider execute(Long id, Provider provider) {
        return providerRepository.update(id, provider);
    }

}