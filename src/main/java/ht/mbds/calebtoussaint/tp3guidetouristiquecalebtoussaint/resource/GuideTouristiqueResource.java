package ht.mbds.calebtoussaint.tp3guidetouristiquecalebtoussaint.resource;

import ht.mbds.calebtoussaint.tp3guidetouristiquecalebtoussaint.llm.LlmClientForGuideTouristique;
import jakarta.inject.Inject;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

/**
 * Ressource REST fournissant un guide touristique (endroits a visiter,
 * prix moyen d'un repas) pour une ville ou un pays donne.
 */
@Path("/guide")
public class GuideTouristiqueResource {

    @Inject
    private LlmClientForGuideTouristique llmClient;

    /**
     * Retourne des informations touristiques pour la ville ou le pays donne.
     *
     * @param villeOuPays le nom de la ville ou du pays sur lequel on veut des informations
     * @param nb le nombre d'endroits a visiter souhaite (2 par defaut)
     * @return la reponse du LLM au format JSON (endroits a visiter, prix moyen d'un repas)
     */
    @GET
    @Path("lieu/{ville_ou_pays}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response endroitsDeVisite(@PathParam("ville_ou_pays") String villeOuPays,
                                     @QueryParam("nb") @DefaultValue("2") int nb) {
        String reponseJson = llmClient.obtenirInfosTouristiques(villeOuPays, nb);

        Response.ResponseBuilder responseBuilder = Response.ok(reponseJson);
        responseBuilder.header("Cache-Control", "no-store, no-cache, must-revalidate, max-age=0");
        responseBuilder.header("Pragma", "no-cache");
        responseBuilder.header("Expires", "0");
        responseBuilder.header("Access-Control-Allow-Origin", "*");
        return responseBuilder.build();
    }
}