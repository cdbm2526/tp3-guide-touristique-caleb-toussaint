package ht.mbds.calebtoussaint.tp3guidetouristiquecalebtoussaint.resource;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

/**
 * Ressource REST fournissant un guide touristique (endroits à visiter,
 * prix moyen d'un repas) pour une ville ou un pays donné.
 */
@Path("/guide")
public class GuideTouristiqueResource {

    /**
     * Retourne des informations touristiques pour la ville ou le pays donné.
     *
     * @param villeOuPays le nom de la ville ou du pays sur lequel on veut des informations
     * @return pour le moment, simplement le paramètre reçu
     */
    @GET
    @Path("lieu/{ville_ou_pays}")
    @Produces(MediaType.TEXT_PLAIN)
    public String endroitsDeVisite(@PathParam("ville_ou_pays") String villeOuPays) {
        return villeOuPays;
    }
}