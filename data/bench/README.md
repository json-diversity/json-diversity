# Bench

This JSON test suite is composed of json files extracted from these sources: 
 * https://github.com/miloyip/nativejson-benchmark
 * https://github.com/GoogleChromeLabs/json-parse-benchmark
 * test suite for https://github.com/akheron/jansson
 * Test suite associated with [Parsing JSON is a minefield](http://seriot.ch/parsing_json.php) https://github.com/nst/JSONTestSuite
 * http://www.json.org/JSON_checker/

In the `correct` directory are Well formed json file, while `errored` contains Ill-formed one. `undefined` contains exemple not so clearcut, but they do conform to the JSON grammar and may be considered as Well formed.
