package org.sagebionetworks.common.util.progress;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.sagebionetworks.common.util.PathNormalizer.normalizeMethodSignature;

public class PathNormalizerTest {

	/*
	 * Synapse API Tests
	 */
	@Test
	public void urlWithoutParameters() {
		assertEquals("/certifiedusertestresponse", normalizeMethodSignature("/repo/v1/certifiedUserTestResponse", "POST"));
	}

	@Test
	public void urlWithSynId() {
		assertEquals("/entity/#/bundle", normalizeMethodSignature("/repo/v1/entity/syn1571204/bundle", "GET"));
	}

	@Test
	public void urlWithEvaluationSubmissionId() {
		assertEquals("/evaluation/submission/#/status", normalizeMethodSignature("/repo/v1/evaluation/submission/2813223/status", "GET"));
	}

	@Test
	public void urlWithEntityIdAndVersionNumber() {
		assertEquals("/entity/#/version/#/filepreview", normalizeMethodSignature("/repo/v1/entity/syn2785825/version/1/filepreview", "GET"));
	}

	@Test
	public void urlWithWiki2AndWikiVersionNumber() {
		assertEquals("/evaluation/#/wiki2/#/#", normalizeMethodSignature("/repo/v1/evaluation/2785825/wiki2/2813234/2", "PUT"));
	}

	@Test
	public void urlWith4IdFields() {
		assertEquals("/entity/#/table/column/#/row/#/version/#/filepreview", normalizeMethodSignature("/repo/v1/entity/syn3456789/table/column/1/row/12/version/2/filepreview", "GET"));
	}

	@Test
	public void urlStartWithFileV1() {
		assertEquals("/createchunkedfileuploadchunkurl", normalizeMethodSignature("/file/v1/createChunkedFileUploadChunkURL", "POST"));
	}

	@Test
	public void urlStartWithAuthV1() {
		assertEquals("/session", normalizeMethodSignature("/auth/v1/session", "POST"));
	}

	@Test
	public void md5UrlTest() {
		assertEquals("/entity/md5/#", normalizeMethodSignature("/repo/v1/entity/md5/0b3ea097271bd405839fca053688c5aa", "GET"));
	}

	@Test
	public void evaluationNameUrlTest() {
		assertEquals("/evaluation/name/#", normalizeMethodSignature("/repo/v1/evaluation/name/challenge0evaluation", "GET"));
	}

	@Test
	public void entityAliasUrlTest() {
		assertEquals("/entity/alias/#", normalizeMethodSignature("/repo/v1/entity/alias/auditData", "GET"));
	}

}
