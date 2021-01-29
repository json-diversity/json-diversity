package se.kth.assertteam.jsonbench.parser;

import se.kth.assertteam.jsonbench.JP;
import org.kopitubruk.util.json.JsonObject;
import org.kopitubruk.util.json.JSONParser;
import org.kopitubruk.util.json.JSONUtil;

import java.util.List;
import java.util.Map;

public class JsonUtil implements JP {
	@Override
	public Object parseString(String in) throws Exception {
		return JSONParser.parseJSON(in);
	}

	@Override
	public String print(Object in) throws Exception {
		return JSONUtil.toJSON(in);
	}

	@Override
	public String getName() {
		return "jsonutil";
	}

	@Override
	public boolean equivalence(Object a, Object b) {
		if(a == null) return b == null;
		if(a.getClass() != b.getClass()) {
			return false;
		} else if(a.equals(b)) {
			return true;
		} else if(a instanceof Map) {
			Map ao, bo;
			ao = (Map) a;
			bo = (Map) b;
			if(ao.size() != bo.size()) {
				return false;
			}
			for(Object ok: ao.keySet()) {
				String key = ok.toString();
				if(!bo.containsKey(key)) return false;
				if(!equivalence(ao.get(key), bo.get(key))) return false;
			}
			return true;
		} else if(a instanceof List) {
			List ao, bo;
			ao = (List) a;
			bo = (List) b;
			if(ao.size() != bo.size()) {
				return false;
			}
			for(int i = 0; i < ao.size(); i++) {
				if (!equivalence(ao.get(i), bo.get(i))) return false;
			}
			return true;
		}
		return false;
	}
}
