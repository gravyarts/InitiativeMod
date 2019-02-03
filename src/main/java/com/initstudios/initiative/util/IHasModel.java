/*
    Copyright (C) 2018-2019 Init Studios. All rights reserved.

    This document is the property of Init Studios.
    It is considered confidential and proprietary.

    This document may not be reproduced or transmitted in any form,
    in whole or in part, without the express written permission of
    Init Studios.
 */

package com.initstudios.initiative.util;

/**
 * The {@code IHasModel} interface indicates something that has a model, such as a block or item.
 *
 * When this interface is implemented, you must include the {@code registerModels()} method.
 */
public interface IHasModel {
	void registerModels();

}
