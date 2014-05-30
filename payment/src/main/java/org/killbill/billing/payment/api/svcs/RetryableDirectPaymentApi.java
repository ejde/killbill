/*
 * Copyright 2014 Groupon, Inc
 *
 * Groupon licenses this file to you under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at:
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package org.killbill.billing.payment.api.svcs;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import javax.inject.Inject;

import org.killbill.billing.account.api.Account;
import org.killbill.billing.callcontext.InternalCallContext;
import org.killbill.billing.catalog.api.Currency;
import org.killbill.billing.payment.api.DirectPayment;
import org.killbill.billing.payment.api.DirectPaymentApi;
import org.killbill.billing.payment.api.PaymentApiException;
import org.killbill.billing.payment.api.PluginProperty;
import org.killbill.billing.payment.core.RetryableDirectPaymentProcessor;
import org.killbill.billing.util.callcontext.CallContext;
import org.killbill.billing.util.callcontext.InternalCallContextFactory;
import org.killbill.billing.util.callcontext.TenantContext;
import org.killbill.billing.util.entity.Pagination;

public class RetryableDirectPaymentApi implements DirectPaymentApi {

    private final RetryableDirectPaymentProcessor retryableDirectPaymentProcessor;
    private final InternalCallContextFactory internalCallContextFactory;

    @Inject
    public RetryableDirectPaymentApi(final RetryableDirectPaymentProcessor retryableDirectPaymentProcessor,
                                     final InternalCallContextFactory internalCallContextFactory) {
        this.retryableDirectPaymentProcessor = retryableDirectPaymentProcessor;
        this.internalCallContextFactory = internalCallContextFactory;
    }

    @Override
    public DirectPayment createAuthorization(final Account account, final UUID paymentMethodId, final UUID directPaymentId, final BigDecimal amount, final Currency currency, final String directPaymentExternalKey, final String directPaymentTransactionExternalKey, final Iterable<PluginProperty> properties, final CallContext callContext) throws PaymentApiException {
        final InternalCallContext internalContext = internalCallContextFactory.createInternalCallContext(account.getId(), callContext);
        return retryableDirectPaymentProcessor.createAuthorization(account, paymentMethodId, directPaymentId, amount, currency, directPaymentExternalKey, directPaymentTransactionExternalKey, properties, callContext, internalContext);
    }

    @Override
    public DirectPayment createCapture(final Account account, final UUID directPaymentId, final BigDecimal amount, final Currency currency, final String directPaymentTransactionExternalKey, final Iterable<PluginProperty> properties, final CallContext context) throws PaymentApiException {
        return null;
    }

    @Override
    public DirectPayment createPurchase(final Account account, final UUID paymentMethodId, final UUID directPaymentId, final BigDecimal amount, final Currency currency, final String directPaymentExternalKey, final String directPaymentTransactionExternalKey, final Iterable<PluginProperty> properties, final CallContext callContext) throws PaymentApiException {
        return null;
    }

    @Override
    public DirectPayment createVoid(final Account account, final UUID directPaymentId, final String directPaymentTransactionExternalKey, final Iterable<PluginProperty> properties, final CallContext context) throws PaymentApiException {
        return null;
    }

    @Override
    public DirectPayment createRefund(final Account account, final UUID uuid, final BigDecimal bigDecimal, final Currency currency, final String s, final Iterable<PluginProperty> pluginProperties, final CallContext callContext) throws PaymentApiException {
        return null;
    }

    @Override
    public DirectPayment createCredit(final Account account, final UUID uuid, final UUID uuid2, final BigDecimal bigDecimal, final Currency currency, final String s, final String s2, final Iterable<PluginProperty> pluginProperties, final CallContext callContext) throws PaymentApiException {
        return null;
    }

    @Override
    public List<DirectPayment> getAccountPayments(final UUID accountId, final TenantContext context) throws PaymentApiException {
        return null;
    }

    @Override
    public DirectPayment getPayment(final UUID directPaymentId, final boolean withPluginInfo, final Iterable<PluginProperty> properties, final TenantContext context) throws PaymentApiException {
        return null;
    }

    @Override
    public Pagination<DirectPayment> getPayments(final Long offset, final Long limit, final Iterable<PluginProperty> properties, final TenantContext context) {
        return null;
    }

    @Override
    public Pagination<DirectPayment> getPayments(final Long offset, final Long limit, final String pluginName, final Iterable<PluginProperty> properties, final TenantContext context) throws PaymentApiException {
        return null;
    }

    @Override
    public Pagination<DirectPayment> searchPayments(final String searchKey, final Long offset, final Long limit, final Iterable<PluginProperty> properties, final TenantContext context) {
        return null;
    }

    @Override
    public Pagination<DirectPayment> searchPayments(final String searchKey, final Long offset, final Long limit, final String pluginName, final Iterable<PluginProperty> properties, final TenantContext context) throws PaymentApiException {
        return null;
    }
}