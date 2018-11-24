package br.com.wsswapi.util;

import br.com.wsswapi.dto.PlanetaSWDTO;
import br.com.wsswapi.dto.ResultadoDTO;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe de desserialização do {@link ResultadoDTO}.
 */
public class JsonResultadoDTODeserializer extends JsonDeserializer<ResultadoDTO> {

	@Override
	public ResultadoDTO deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
		ObjectCodec oc = jsonParser.getCodec();
		JsonNode node = oc.readTree(jsonParser);

		Integer count = node.get("count").intValue();
		List<PlanetaSWDTO> results = new ArrayList<>();

		JsonNode arrayNode = node.get("results");

		if (arrayNode.isArray()) {
			arrayNode.forEach(n -> {
				String name = n.get("name").textValue();
				JsonNode aN = n.get("films");
				Integer amountFilms = aN.isArray() ? aN.size() : BigInteger.ZERO.intValue();
				results.add(new PlanetaSWDTO(name, amountFilms));
			});
		}

		return new ResultadoDTO(count, results);
	}
}
