generate-api:
	java -jar fabrikt-19.0.0.jar \
		--output-directory . \
		--base-package com.example.generated \
		--api-file api.yaml \
		--targets http_models \
		--targets controllers \
		--http-controller-target ktor \
		--serialization-library KOTLINX_SERIALIZATION \
		--http-model-opts SEALED_INTERFACES_FOR_ONE_OF \
		--validation-library NO_VALIDATION \
		