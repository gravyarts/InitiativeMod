package com.initstudios.initiative.api.initportals;

public class InitPortalsApi
{
    private static IApi api = new ApiDummy();

    /**
     * Get the IApi implementation for Init Portals.
     *
     * @return returns the IApi implementation for Init Portals. May be the ApiDummy if Init Portals has not loaded.
     */
    public static IApi getApiImpl()
    {
        return api;
    }

    /**
     * Sets the IApi implementation for Init Portals.
     * For use of Init Portals, so please don't actually use this. Please.
     *
     * @param apiImpl API implementation to set.
     */
    public static void setApiImpl(IApi apiImpl)
    {
        InitPortalsApi.api = apiImpl;
    }
}
